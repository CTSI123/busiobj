package cn.com.ctsi.busiobj.bean.request.cdm.table;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Arrays;


public class CdmTemplateTableQueryReq extends TableReq implements Serializable {

	private static final long serialVersionUID = -5105499399413818224L;

	@NotNull(message = "The param [table_names] is null.")
	@JsonProperty("table_names")
	private String[] tableNames;

	@JsonProperty("table_ids")
	private String tableIds;


	@Override
	public String toString() {
		return "CdmTemplateTableQueryReq{" +
				"tableNames=" + Arrays.toString(tableNames) +
				", tableIds='" + tableIds + '\'' +
				'}';
	}

	public String getTableIds() {
		return tableIds;
	}

	public void setTableIds(String tableIds) {
		this.tableIds = tableIds;
	}

	public String[] getTableNames() {
		return tableNames;
	}

	public void setTableNames(String[] tableNames) {
		this.tableNames = tableNames;
	}
}
