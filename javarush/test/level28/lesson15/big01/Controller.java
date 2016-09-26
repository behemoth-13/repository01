package com.javarush.test.level28.lesson15.big01;
import com.javarush.test.level28.lesson15.big01.model.Model;




public class Controller {

    private Model model;

    public Controller(Model model)
    {
        if (model == null) {
            throw new IllegalArgumentException();
        }
        this.model = model;
    }

    public void onCitySelect(String cityName)
    {
        model.selectCity(cityName);
    }

    //private Provider[] providers;

    /*public Controller(Provider... providers) {
        if (providers.length == 0)
            throw new IllegalArgumentException();
        else
            this.providers = providers;
    }

    @Override
    public String toString() {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
    }

    public void scan() {
        List<Vacancy> allVacancies = new ArrayList<>();
        List<Vacancy> currentVacancies;
        for (Provider currentProvider : providers){
            try {
                currentVacancies = currentProvider.getJavaVacancies("odessa");
                allVacancies.addAll(currentVacancies);
                currentVacancies.clear();
            }catch (NullPointerException npe) {}
        }
        System.out.println(allVacancies.size());
        for (Vacancy v : allVacancies){
            System.out.println( v.getTitle() + " : " + v.getCity() + " : "
                    + v.getCompanyName() + " : " + v.getSalary() + " : " + v.getUrl());
        }
    }*/
}