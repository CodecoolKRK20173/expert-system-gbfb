package com.codecool.expertsystem;

import com.codecool.expertsystem.parsers.FactParser;
import com.codecool.expertsystem.repositories.FactRepository;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        FactParser factParser = new FactParser();
        FactRepository factRepo = factParser.getFactRepository();

    }
}
