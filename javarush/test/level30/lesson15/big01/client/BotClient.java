package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Alex on 16.09.2016.
 */
public class BotClient extends Client
{
    public static void main(String[] args)
    {
        BotClient bot = new BotClient();
        bot.run();
    }

    private static int botCount = 0;

    @Override
    protected boolean shouldSentTextFromConsole()
    {
        return false;
    }

    @Override
    protected String getUserName()
    {
        if (botCount == 99)
            botCount = 0;
        return "date_bot_" + botCount++;
    }

    @Override
    protected SocketThread getSocketThread()
    {
        return new BotSocketThread();
    }

    public class  BotSocketThread extends SocketThread{
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException
        {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message)
        {
            ConsoleHelper.writeMessage(message);
            String senderName = "";
            String senderMessageText;
            if (message.contains(": ")) {
                senderName = message.substring(0, message.indexOf(": "));
                senderMessageText = message.substring(message.indexOf(": ") + 2);
            }
            else {
                senderMessageText = message;
            }

            Calendar calendar = Calendar.getInstance();

            SimpleDateFormat simpleDateFormat = null;
            switch(senderMessageText){
                case "дата": simpleDateFormat = new SimpleDateFormat("d.MM.YYYY"); break;
                case "день": simpleDateFormat = new SimpleDateFormat("d"); break;
                case "месяц": simpleDateFormat = new SimpleDateFormat("MMMM"); break;
                case "год": simpleDateFormat = new SimpleDateFormat("YYYY"); break;
                case "время": simpleDateFormat = new SimpleDateFormat("H:mm:ss"); break;
                case "час": simpleDateFormat = new SimpleDateFormat("H"); break;
                case "минуты": simpleDateFormat = new SimpleDateFormat("m"); break;
                case "секунды": simpleDateFormat = new SimpleDateFormat("s"); break;

            }
            if (simpleDateFormat != null)
            {
                sendTextMessage("Информация для " + senderName + ": " + simpleDateFormat.format(calendar.getTime()));
            }
        }
    }
}
