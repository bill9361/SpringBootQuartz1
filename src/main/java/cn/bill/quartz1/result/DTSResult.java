package cn.bill.quartz1.result;

import java.util.Date;

/**
 * Description: <br/>
 * Date:2018年9月14日 上午10:34:50 <br/>
 *
 * @author fengminbiao@126.com
 * @version
 */

public class DTSResult
{
	private boolean success;
	private String errorMsg;
	private String duration;
	private Date createTime;
	private long JobId;
	
	public boolean isSuccess()
	{
		return success;
	}
	public void setSuccess(boolean success)
	{
		this.success = success;
	}
	public String getErrorMsg()
	{
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg)
	{
		this.errorMsg = errorMsg;
	}
	public String getDuration()
	{
		return duration;
	}
	public void setDuration(String duration)
	{
		this.duration = duration;
	}
	public Date getCreateTime()
	{
		return createTime;
	}
	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}
	public long getJobId()
	{
		return JobId;
	}
	public void setJobId(long jobId)
	{
		JobId = jobId;
	}
	@Override
	public String toString()
	{
		return "DTSResult [success=" + success + ", errorMsg=" + errorMsg + ", duration=" + duration + ", createTime="
				+ createTime + ", JobId=" + JobId + "]";
	}
	
}
