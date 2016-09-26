package com.javarush.test.level32.lesson15.big01;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

/**
 * Created by Alex on 24.09.2016.
 */
public class Controller
{
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public static void main(String[] args)
    {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }

    public Controller(View view)
    {
        this.view = view;
    }

    public void init(){
        createNewDocument();
    }

    public void exit(){
        System.exit(0);
    }

    public HTMLDocument getDocument()
    {
        return document;
    }

    public void resetDocument(){
        if (document != null){
            document.removeUndoableEditListener(view.getUndoListener());
        }
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener( view.getUndoListener());
        view.update();
    }

    public void  setPlainText(String text){
        try{
            resetDocument();
            new HTMLEditorKit().read(new StringReader(text), document, 0);
        }
        catch(Exception e){
            ExceptionHandler.log(e);
        }
    }

    public String getPlainText(){
        String s = "";
        try{
            StringWriter stringWriter = new StringWriter();
            new HTMLEditorKit().write(stringWriter, document, 0, document.getLength());
            s = stringWriter.toString();
        }
        catch(Exception e){
            ExceptionHandler.log(e);
        }
        return s;
    }

    public void createNewDocument()
    {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;
    }

    public void openDocument()
    {
        view.selectHtmlTab();
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new HTMLFileFilter());
        int n = chooser.showOpenDialog(view);
        if (n == JFileChooser.APPROVE_OPTION)
        {
            currentFile = chooser.getSelectedFile();;
            resetDocument();
            view.setTitle(currentFile.getName());
            try(FileReader fileReader = new FileReader(currentFile)){
                new HTMLEditorKit().read(fileReader, document, 0);
                view.resetUndo();
            }
            catch (Exception e)
            {
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocument()
    {
        if (currentFile == null)
            saveDocumentAs();
        else{
            view.selectHtmlTab();
            try(FileWriter fileWriter = new FileWriter(currentFile);)
            {
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
            }
            catch (Exception e)
            {
                ExceptionHandler.log(e);
            }
        }
    }


    public void saveDocumentAs()
    {
        view.selectHtmlTab();
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new HTMLFileFilter());
        int n = chooser.showSaveDialog(view);
        File selectedFile = chooser.getSelectedFile();
        if (n == JFileChooser.APPROVE_OPTION)
        {
            currentFile = selectedFile;
            view.setTitle(currentFile.getName());
            try(FileWriter fileWriter = new FileWriter(currentFile);)
            {
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
            }
            catch (Exception e)
            {
                ExceptionHandler.log(e);
            }
        }
    }
}