package com.aoeai.mybatismysqltest.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * aoeai mysql tools generate.
 * DB WorkerID Assigner for UID Generator
 *
 */
@Data
public class WorkerNode {

	/**
	 * auto increment id
	 */
	private Long id;

	/**
	 * host name
	 */
	@NotNull(message = "hostName 不能为空")
	private String hostName;

	/**
	 * port
	 */
	@NotNull(message = "port 不能为空")
	private String port;

	/**
	 * node type: ACTUAL or CONTAINER
	 */
	@NotNull(message = "type 不能为空")
	private Integer type;

	/**
	 * launch date
	 */
	private Date launchDate;

	/**
	 * modified time
	 */
	private Date modified;

	/**
	 * created time
	 */
	private Date created;


}