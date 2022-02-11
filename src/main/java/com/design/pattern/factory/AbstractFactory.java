package com.design.pattern.factory;

/**
 * 抽象工厂模式
 */
public class AbstractFactory {
    public static void main(String[] args) {
//        IDatabaseUtils databaseUtils = new MysqlDatabaseUtils();
        IDatabaseUtils databaseUtils = new OracleDatabaseUtils();
        IConnection connection = databaseUtils.getConnection();
        connection.connect();
        ICommand command = databaseUtils.getCommand();
        command.command();

        //源码应用
        java.sql.Connection conn;
        java.sql.Driver driver;
    }
}

//变化：mysql、oracle
//connection、command

interface IConnection {
    void connect();
}

class MysqlConnection implements IConnection{
    @Override
    public void connect() {
        System.out.println("mysql connect");
    }
}
class OracleConnection implements IConnection{
    @Override
    public void connect() {
        System.out.println("oracle connect");
    }
}

interface ICommand {
    void command();
}

class MysqlCommand implements ICommand{
    @Override
    public void command() {
        System.out.println("mysql command");
    }
}
class OracleCommand implements ICommand{
    @Override
    public void command() {
        System.out.println("oracle command");
    }
}

interface IDatabaseUtils {
    IConnection getConnection();
    ICommand getCommand();
}

class MysqlDatabaseUtils implements IDatabaseUtils{
    @Override
    public IConnection getConnection() {
        return new MysqlConnection();
    }
    @Override
    public ICommand getCommand() {
        return new MysqlCommand();
    }
}
class OracleDatabaseUtils implements IDatabaseUtils{
    @Override
    public IConnection getConnection() {
        return new OracleConnection();
    }
    @Override
    public ICommand getCommand() {
        return new OracleCommand();
    }
}
