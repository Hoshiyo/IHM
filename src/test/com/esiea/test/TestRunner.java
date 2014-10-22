package com.esiea.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.esiea.test.entity.EntityTestSuite;
import com.esiea.test.model.dao.impl.DAOTestSuite;

public class TestRunner {
  public static void main(String[] args) {
    Result result = JUnitCore.runClasses(EntityTestSuite.class, DAOTestSuite.class);
    for (Failure failure : result.getFailures()) {
      System.out.println(failure.toString());
    }
    if(result.getFailures().size()==0)
    {
    	System.out.println("Success !");
    }
  }
} 