package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;
import java.util.List;

/**
 * Created by Alex on 07.08.2016.
 */
public class HtmlView implements View
{
    private final String filePath = this.getClass().getPackage().toString().replace('.', '/').replaceFirst("package ", "./src/")+"/" + "vacancies.html";
    private Controller controller;

    public void userCitySelectEmulationMethod()
    {
        controller.onCitySelect("Odessa");
    }

    @Override
    public void update(List<Vacancy> vacancies)
    {
        String forUpdate = getUpdatedFileContent(vacancies);
        updateFile(forUpdate);
        System.out.println("Количество вакансий: " + vacancies.size());
    }

    @Override
    public void setController(Controller controller)
    {
        this.controller = controller;
    }

    private String getUpdatedFileContent(List<Vacancy> list)
    {
        String fileContent;
        try {
            Document doc = getDocument();
            Element templateElement = doc.select(".template").first();

            Element patternElement = templateElement.clone();
            patternElement.removeAttr("style");
            patternElement.removeClass("template");

            doc.select("tr[class=vacancy]").remove();

            for (Vacancy vacancy : list) {
                Element newVacancyElement = patternElement.clone();
                newVacancyElement.getElementsByClass("city").first().text(vacancy.getCity());
                newVacancyElement.getElementsByClass("companyName").first().text(vacancy.getCompanyName());
                newVacancyElement.getElementsByClass("salary").first().text(vacancy.getSalary());
                Element link = newVacancyElement.getElementsByTag("a").first();
                link.text(vacancy.getTitle());
                link.attr("href", vacancy.getUrl());

                templateElement.before(newVacancyElement.outerHtml());
            }
            fileContent = doc.html();
        }
        catch (IOException e) {
            e.printStackTrace();
            fileContent = "Some exception occurred";
        }
        return fileContent;
    }

    protected Document getDocument() throws IOException {
        return Jsoup.parse(new File(filePath), "UTF-8");
    }

    private void updateFile(String s)
    {
        try
        {
            BufferedWriter fWriter = new BufferedWriter(new FileWriter(filePath));
            fWriter.write(s);
            fWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
