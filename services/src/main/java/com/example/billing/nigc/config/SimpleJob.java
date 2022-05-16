package com.example.billing.nigc.config;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

public class SimpleJob implements Job{
  
  @Override
  public void execute(JobExecutionContext jobExecutionContext) {
    
    System.out.println("job start.....");
    try {
      Thread.sleep( 50000000 );
    } catch (Exception e) {
      e.printStackTrace();
    }finally {
      System.out.println("job end....");
    }
    
  
  }
}