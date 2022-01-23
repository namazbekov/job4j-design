package ru.job4j.io;

import org.hamcrest.Matchers;
import org.junit.Test;
import java.util.NoSuchElementException;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./data//app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("something"), is(Matchers.nullValue()));
    }

    @Test
    public void whenPairWithoutComment2() {
        String path = "./data//add.properties";
        Config config = new Config(path);
        config.load();
        try {
            config.value("vjfnvj");
        } catch (NoSuchElementException e) {
            System.out.println("Нет такого ключа");
        }
    }

    @Test
    public void whenFileContainsException3() throws IllegalArgumentException {
        String path = "./data//arr.properties";
        Config config = new Config(path);
        config.load();
    }

    @Test
    public void whenDontFindElement() throws NoSuchElementException {
        String path = "./data//aff.properties";
        Config config = new Config(path);
        config.load();
    }

    @Test
    public void whenNoLegalElement() throws IllegalArgumentException {
        String path = "./data//acc.properties";
        Config config = new Config(path);
        config.load();
    }
}