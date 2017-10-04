package edu.cnm.deepdive.passphrase;

import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class CommandLine {
 public static void main(String[] args) {
   //type (upper Options) instance (lower options)
   try {
     Options options = buildOptions();
     CommandLineParser parser = new DefaultParser();
     org.apache.commons.cli.CommandLine cmdLine = parser.parse(options, args);
     //see if user is asking for help
     if (cmdLine.hasOption("?")) {
       HelpFormatter formatter = new HelpFormatter();
       formatter.printHelp("java" + CommandLine.class.getName(), options);
     }
   } catch (Exception e) {
     e.printStackTrace();
   }

 }
 private static Options buildOptions() {
   //calling builder methods without having to retype option.builder;  build is the builder and goes last.
   Option sampleOpt = Option.builder("s").argName("value")
                                                   .optionalArg(true)
                                                   .longOpt("sample")
                                                   .desc("Silly description")
                                                   .required()
                                                   .hasArg(true)
                                                    .numberOfArgs(1)
                                                    .type(Number.class)
                                                   .build();
   Option switchOpt = Option.builder("x") .hasArg(false)
                                               .longOpt("exclude")
                                               .desc("Another description")
                                               .build();
   Option helpOpt = Option.builder("?").longOpt("help")
                                            .required(false)
                                            .hasArg(false)
                                            .desc("Display this screen")
       //Note the build.  Must be last.
                                            .build();
   Options options = new Options();
   options.addOption(sampleOpt);
   options.addOption(switchOpt);
   options.addOption(helpOpt);
   return options;
 }
}
