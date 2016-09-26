package com.javarush.test.level30.lesson15.big01;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Alex on 12.09.2016.
 */
public class Server
{
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args)
    {
        ConsoleHelper.writeMessage("Введите порт сервера: ");
        int serverPort = ConsoleHelper.readInt();

        try (ServerSocket serverSocket = new ServerSocket(serverPort)) {

            ConsoleHelper.writeMessage("Сервер запущен");

            while (true) {
                //Слушаем
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                //запускаем handler
                handler.start();
            }
        }
        catch (IOException e)
        {
            ConsoleHelper.writeMessage("Что то пошло не так");
        }
    }

    public static void sendBroadcastMessage(Message message){
        try
        {
            for (Connection connection : connectionMap.values())
                connection.send(message);
        } catch (IOException e){
            ConsoleHelper.writeMessage("Сообщение не отправлено");
        }
    }


    private static class Handler extends Thread{
        private Socket socket;

        public Handler(Socket socket)
        {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            String nameUser;
            while (true){
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message otvet =  connection.receive();
                nameUser = otvet.getData();
                if (otvet.getType() == MessageType.USER_NAME && nameUser.length() > 0 && !connectionMap.containsKey(nameUser))
                {
                    connectionMap.put(nameUser, connection);
                    connection.send(new Message(MessageType.NAME_ACCEPTED));
                    return nameUser;
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException{
            for (String key : connectionMap.keySet())
            {
                if (!key.equals(userName))
                {
                    connection.send(new Message(MessageType.USER_ADDED, key));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while (!isInterrupted()){
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT)
                {
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName.concat(": ").concat(message.getData())));
                }
                else
                    ConsoleHelper.writeMessage("Ошибка в принятом сообщении(не ТЕХТ)");
            }
        }

        @Override
        public void run()
        {
            ConsoleHelper.writeMessage("Соединение запущено с адресом: " + socket.getRemoteSocketAddress());
            String userName = null;
            try(Connection connection = new Connection(socket))
            {
                ConsoleHelper.writeMessage("Подключение к порту: " + connection.getRemoteSocketAddress());
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);
            }
            catch (IOException e)
            {
                ConsoleHelper.writeMessage("произошла ошибка при обмене данными с удаленным адресом");
            }
            catch (ClassNotFoundException e)
            {
                ConsoleHelper.writeMessage("произошла ошибка при обмене данными с удаленным адресом1");
            }
            connectionMap.remove(userName);
            if (userName != null)
            {
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
            }
            ConsoleHelper.writeMessage("Соединение с удаленным адресом закрыто");
        }
    }
}
