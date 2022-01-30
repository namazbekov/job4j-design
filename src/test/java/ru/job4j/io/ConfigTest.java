package ru.job4j.io;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.util.NoSuchElementException;


public class ConfigTest {

    private static Config config;
    private static String path;

    @BeforeClass
    public static void beforeClass() {
        config = new Config(path);
    }

    @Rule
    public ExpectedException expect = ExpectedException.none();

    @Test (expected = NoSuchElementException.class)
    public void whenPairWithoutComment() {
        path = "./data/app.properties";
        config = new Config(path);
        config.load();
        config.value("something");
    }

    @Test (expected = NoSuchElementException.class)
    public void whenPairWithoutComment2() {
        String path = "./data/add.properties";
        config = new Config(path);
        config.load();
        config.value("oajdnvij");
    }

    @Test
    public void whenFileContainsException3() {
        String path = "./data/arr.properties";
        config = new Config(path);
        expect.expect(IllegalArgumentException.class);
        config.load();
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenDontFindElement() {
        path = "./data/aff.properties";
        config = new Config(path);
        config.load();
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenNoLegalElement() {
        String path = "./data/acc.properties";
        Config config = new Config(path);
        config.load();
    }
    @Test (expected = IllegalArgumentException.class)
    public void whenHaveTwoEquals() {
        String path = "./data/akk.properties";
        Config config = new Config(path);
        config.load();
    }
}