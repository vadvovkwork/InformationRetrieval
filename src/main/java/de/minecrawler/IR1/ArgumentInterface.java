/*
 * Copyright (C) 2013
 * 
 * This file is part of InformationRetrieval.
 * 
 * InformationRetrieval is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 3 of the License.
 * 
 * InformationRetrieval is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with InformationRetrieval.  If not, see <http://www.gnu.org/licenses/>.
 */

package de.minecrawler.IR1;

import java.util.concurrent.TimeUnit;

import org.apache.commons.cli.Options;

/**
 * Handler for using console arguments to start the information retrieval.
 * 
 * @author Meldanor
 * 
 */
public class ArgumentInterface {

    /**
     * Possible argument options
     */
    private Options options;

    /**
     * Starts the interface using the console arguments.
     * 
     * @param args
     *            The arguments from the console
     */
    public ArgumentInterface(String[] args) {
        this.options = createOptions();
        handleArguments(args);
    }

    /**
     * Creates possible options to parse.
     * 
     * @return Container with all information about possible options
     */
    private Options createOptions() {
        Options options = new Options();

//        // Option -f or --file defining the xml file to parse
//        options.addOption("f", "file", true, "XML file to parse");
//        // Option -c or --console says, that the output will be presented on the
//        // console instead of creating a result file.
//        options.addOption("c", "console", false, "Query output is in the console");
//
//        options.addOption("l", "limit", true, "Number of max results");

        return options;
    }

    private void handleArguments(String[] args) {
//        // Create Possix compatible arguments parser
//        CommandLineParser parser = new PosixParser();
//        // If no other file is defined, use the standard file
//        InputStream xmlStream = getClass().getResourceAsStream("/reut2-000.xml");
//        // Shows the query output on the console
//        boolean showInConsole = false;
//
//        int limit = 10;
//        try {
//            CommandLine line = parser.parse(options, args);
//            // User has defined own file -> parse this file
//            if (line.hasOption("file")) {
//                String fileName = line.getOptionValue("file");
//                try {
//                    xmlStream = new FileInputStream(new File(fileName));
//                } catch (FileNotFoundException e) {
//                    System.out.println("File " + fileName + " does not exist!");
//                    return;
//                }
//                System.out.println("Searching in file " + fileName);
//            }
//            if (line.hasOption("limit")) {
//                String tmp = line.getOptionValue("limit");
//                try {
//                    limit = Integer.parseInt(tmp);
//                } catch (Exception e) {
//                    System.out.println(tmp + " is not a number!");
//                }
//            }
//
//            // Shows the query output on the console
//            showInConsole = line.hasOption("console");
//
//            // Non parsed arguments are the query
//            args = line.getArgs();
//            String query = buildQuery(args);
//
//            startQuery(xmlStream, showInConsole, query, limit);
//        } catch (ParseException e) {
//            HelpFormatter formatter = new HelpFormatter();
//            formatter.printHelp("", options);
//            return;
//        }

    }
//
//    /**
//     * Connects all non parsed arguments from the console to one single string,
//     * the query.
//     * 
//     * @param args
//     *            The non parsed arguments
//     * @return One string containing all other strings separated by a whitespace
//     */
//    private String buildQuery(String[] args) {
//        StringBuilder sBuilder = new StringBuilder();
//        int i = 0;
//        for (; i < args.length - 1; ++i) {
//            sBuilder.append(args[i]);
//            sBuilder.append(' ');
//        }
//        sBuilder.append(args[i]);
//
//        return sBuilder.toString();
//    }
//
//    /**
//     * Starts the query
//     * 
//     * @param xmlFile
//     *            The xml file as a database to search on
//     * @param showInConsole
//     *            Shows the output on the console
//     * @param query
//     *            The query to be executed
//     * @param limit
//     *            Maximum number of results to display
//     */
//    private void startQuery(InputStream xmlFile, boolean showInConsole, String query, int limit) {
//        InformationRetrievalSystem irSystem = null;
//        long time = System.nanoTime();
//        try {
//            irSystem = new InformationRetrievalSystem(xmlFile);
//        } catch (Exception e) {
//            System.out.println("Error while parsing the XML file");
//            e.printStackTrace();
//        }
//        time = System.nanoTime() - time;
//        System.out.println("Query: " + query);
//        System.out.println("Limit: " + limit);
//        ResultXMLDocumentList result = irSystem.search(query, limit);
//        showResults(showInConsole, result, time);
//    }
//
//    /**
//     * Shows the results
//     * 
//     * @param showInConsole
//     *            Show the output on the console<br>
//     *            If <code>false</code> the output will be written into a file
//     * @param result
//     *            The result of the query
//     * @param time
//     *            The time the query needs to be executed
//     */
//    private void showResults(boolean showInConsole, ResultXMLDocumentList result, long time) {
//        System.out.println("Results: " + result.size());
//        printTime(time);
//        try {
//            JAXBContext jc = JAXBContext.newInstance(Core.XML_ENTITY_PACKAGE);
//            Marshaller marshaller = jc.createMarshaller();
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            if (showInConsole) {
//                marshaller.marshal(result, System.out);
//            } else {
//                File f = createResultFile();
//                System.out.println("Result is in " + f);
//                marshaller.marshal(result, f);
//            }
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//    }

    private void printTime(long time) {
        long seconds = TimeUnit.NANOSECONDS.toSeconds(time);
        time = time - TimeUnit.SECONDS.toNanos(seconds);

        long millis = TimeUnit.NANOSECONDS.toMillis(time);
        time = time - TimeUnit.MILLISECONDS.toNanos(millis);

        long micros = TimeUnit.NANOSECONDS.toMicros(time);
        time = time - TimeUnit.MICROSECONDS.toNanos(micros);

        System.out.println("Query executed in " + seconds + "s " + millis + "ms " + micros + "micro");
    }

//    /**
//     * @return A not used file as output
//     */
//    private File createResultFile() {
//        for (int i = 0;; ++i) {
//            File f = new File("result" + i + ".xml");
//            if (!f.exists())
//                return f;
//        }
//    }
}
