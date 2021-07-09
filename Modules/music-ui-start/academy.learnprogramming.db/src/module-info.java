module academy.learnprogramming.db {
    exports academy.learnprogramming.db;
    requires java.sql;
    requires sqlite.jdbc;
    requires transitive academy.learnprogramming.common;
}