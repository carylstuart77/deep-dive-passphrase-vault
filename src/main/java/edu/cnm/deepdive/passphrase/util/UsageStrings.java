package edu.cnm.deepdive.passphrase.util;

import java.util.ResourceBundle;

public class UsageStrings {
  //Singleton One thread of execution
  //Want to be thread safe
  private final ResourceBundle bundle;

  private static class Singleton {
    //inner class; cannot be seen outside closing class
    private static final UsageStrings INSTANCE = new UsageStrings();
  }

  private UsageStrings() {
    bundle = ResourceBundle.getBundle(Constants.USAGE_BUNDLE);
  }

  public static ResourceBundle getBundle(){
    return Singleton.INSTANCE.bundle;
  }

}
