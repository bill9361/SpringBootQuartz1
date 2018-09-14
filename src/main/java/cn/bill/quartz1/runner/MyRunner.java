package cn.bill.quartz1.runner;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import cn.bill.quartz1.entity.QuartzJobBean;
import cn.bill.quartz1.service.QuartzJobService;
import cn.bill.quartz1.service.TaskService;

@Component
public class MyRunner implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired     
    private TaskService taskService;

    @Autowired
    private QuartzJobService jobService;

    @Override
    public void run(String... args) throws Exception {
        // 可执行的任务列表        
        List<QuartzJobBean> taskList = jobService.findByJobStatus(QuartzJobBean.STATUS_RUNNING);     
        logger.info("初始化加载定时任务......");     
        for (QuartzJobBean job : taskList) {     
            try {
            	System.out.println(job);
                taskService.addJob(job);     
            } catch (Exception e) {
                logger.error("add job error: " + job.getJobName() + " " + job.getJobGroup(), e);
            }
        }  
    }

}