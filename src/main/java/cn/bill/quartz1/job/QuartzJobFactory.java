package cn.bill.quartz1.job;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.Trigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.bill.quartz1.entity.QuartzJobBean;
import cn.bill.quartz1.result.DTSResult;
import cn.bill.quartz1.service.QuartzJobService;
import cn.bill.quartz1.util.SpringUtils;
import cn.bill.quartz1.util.TaskUtils;

/**     
 * Job实现类  无状态     
 * 若此方法上一次还未执行完，而下一次执行时间轮到时则该方法也可并发执行     
 */    
public class QuartzJobFactory implements Job {

    private final Logger logger = LoggerFactory.getLogger(this.getClass()); 

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDetail job = context.getJobDetail();
        JobKey key = job.getKey();
        String jobIdentity = "scheduleJob" + key.getGroup() + "_" + key.getName();
        Trigger trigger = context.getTrigger();
        QuartzJobBean scheduleJob = (QuartzJobBean) context.getMergedJobDataMap().get(jobIdentity);
        logger.info("运行任务名称 = [" + scheduleJob + "]");

        try {
            DTSResult result = TaskUtils.invokMethod(scheduleJob);

            scheduleJob.setNextTime(trigger.getNextFireTime());
            scheduleJob.setPreviousTime(trigger.getPreviousFireTime());

            QuartzJobService jobService = SpringUtils.getBean("moduleService");
            jobService.modifyByIdAndTime(scheduleJob.getPreviousTime(), scheduleJob.getNextTime(), scheduleJob.getJobId());

            System.out.println(result);
            // 写入运行结果
          /*  DTSResultService dtsService = SpringUtils.getBean("dtsResultService");
            dtsService.save(result);*/
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

}