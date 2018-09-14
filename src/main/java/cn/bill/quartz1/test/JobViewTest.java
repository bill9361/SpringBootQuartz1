package cn.bill.quartz1.test;

import java.util.List;

import org.quartz.SchedulerException;

import cn.bill.quartz1.entity.QuartzJobBean;
import cn.bill.quartz1.service.TaskService;
import cn.bill.quartz1.util.SpringUtils;

public class JobViewTest {

    private TaskService taskService;

    public JobViewTest() {
        taskService = SpringUtils.getBean("taskService");
    }

    public void run() {
        List<QuartzJobBean> jobs;
        try {
            System.out.print("All jobs: ");
            jobs = taskService.getAllJobs();
            for (QuartzJobBean job : jobs) {
                System.out.print(job.getJobGroup() + "_" + job.getJobName() + " " + job.getJobStatus() + "\t");
            }
            System.out.println();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}