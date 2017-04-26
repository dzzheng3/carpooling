package com.tag;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class InputFormTag extends SimpleTagSupport{
	

	
	private String name;
	private String type;
	private String label;
	private String required;
	private String placeholder;
	
	public void doTag() throws IOException{
		
		JspWriter out = getJspContext().getOut();
		out.write("<div class=\"form-group\">");
		out.write("<label>");
		out.write(label);
		String requiredAtt = "";
		
		if(required!=null){
			out.write("<span class=\"required\">*</span>");
			requiredAtt = "required";
		}
		out.write("</label>");
		
		if(type.equals("text")){
			
			out.write("<input placeholder='"+placeholder+"'"
					+ "  type='"+type+"' name='"+name+"'"
							+ " class='form-control' "+requiredAtt+"/>");
			
		}else if(type.equals("textarea")){
			
			out.write("<textarea class='form-control'"
					+ " name='"+name+"' style='height: 70px;' "
							+ "placeholder='"+placeholder+"' "+requiredAtt+"></textarea>");

		}
		
		out.write("</div>");

		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getRequired() {
		return required;
	}
	public void setRequired(String required) {
		this.required = required;
	}
	public String getPlaceholder() {
		return placeholder;
	}
	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}
	
	

}
