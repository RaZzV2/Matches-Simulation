package com.example.javapentalog.FirstModule.Tema2.Singleton;

class Database {

    private static Database db;

    private Database() {

    }
    public static Database getInstance(){
        if(db==null){
            db = new Database();
        }
        return db;
    }

    public void getConnection(){
        System.out.println("You are now connected to the database!");
    }

}
