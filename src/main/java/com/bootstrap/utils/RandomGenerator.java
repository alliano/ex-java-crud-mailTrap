package com.bootstrap.utils;

public class RandomGenerator {
   
   public static long generate(long min, long max){
      long result = min + (long) (Math.random() * (max-min));
      return result;
   }
}
