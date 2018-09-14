package cn.bill.quartz1.service;

import java.util.Date;
import java.util.List;

import cn.bill.quartz1.entity.QuartzJobBean;

/**
 * Description: <br/>
 * Date:2018年9月14日 上午10:26:06 <br/>
 *
 * @author fengminbiao@126.com
 * @version
 */

public interface QuartzJobService
{

	List<QuartzJobBean> findAll();

	QuartzJobBean save(QuartzJobBean jobBean);

	QuartzJobBean getOne(long jobId);

	int modifyByIdAndTime(Date previousTime, Date nextTime, Long jobId);

	List<QuartzJobBean> findByJobStatus(String jobStatus);

	List<QuartzJobBean> findByJobStatusNot(String jobStatus);

	int modifyByStatus(String jobStatus, Long jobId);

}
