package utils;

import java.io.Serializable;
/**
 * 
 * @author 薛宗艳
 *
 */
public class JsonResult implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1980308374410013618L;
	//服务器返回的消息
    private String message;
    //状态码  0:成功,其他表示失败
    private String state;
    //服务器返回的数据
    private Object data;
	public JsonResult() {
		super();
	}
	public JsonResult(String message, String state, Object data) {
		super();
		this.message = message;
		this.state = state;
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JsonResult other = (JsonResult) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "JsonResult [message=" + message + ", state=" + state + ", data=" + data + "]";
	}
    
}