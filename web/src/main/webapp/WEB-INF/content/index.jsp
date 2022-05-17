<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html lang="en-US">
<head>
    <meta charset="UTF-8"/>
    <title>Sample page of integration spring boot and struts</title>
    <sj:head jqueryui="true" jquerytheme="cupertino"/>
    <style>
        #accounts {
            font-family: Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #accounts td, #accounts th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #accounts tr:nth-child(even){background-color: #f2f2f2;}

        #accounts tr:hover {background-color: #ddd;}

        #accounts th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #04AA6D;
            color: white;
        }
    </style>
    </style>
</head>
<body>
<sj:tabbedpanel id="localtabs">
  <sj:tab id="tab1" target="ListAccount" label="List Account"/>
      <sj:tab id="tab2" target="Account" label="Account"/>
      <sj:tab id="tab3" target="Report" label="Report"/>

  <div id="ListAccount">
      <div style="margin-top: 40px; margin-right: 150px; margin-left: 150px;">
          <table id="accounts">
              <thead>
              <tr>
                  <th>#</th>
                  <th>NAME</th>
                  <th>Last Name</th>
                  <th>Age</th>
                  <th>Address</th>
                  <th>Amount</th>
                  <th>Interest</th>
              </tr>
              </thead>
              <s:iterator value="accounts">
                  <tr style="border: black; border-size:1px;">
                      <td><s:property value="id"/> </td>
                      <td><s:property value="name" /></td>
                      <td><s:property value="lastName" /></td>
                      <td><s:property value="age"/> </td>
                      <td><s:property value="address" /></td>
                      <td><s:property value="amount" /></td>
                      <td><s:property value="newAmount" /></td>
                  </tr>
              </s:iterator>
          </table>
      </div>
  </div>
    <div id="Account">
        <div align="left">
            <h3>Add account to database</h3>
            <s:form action="addAccount" method="post">
                <s:textfield name="name" label="Name" />
                <s:textfield name="lastName" label="LastName"  />
                <s:textfield name="age" label="Age"  />
                <s:textfield name="address" label="Address" />
                <s:textfield name="amount" label="Amount" />
                <s:submit value="Account" />
            </s:form>
        </div>
    </div>
    <div id="Report">
        <h3>Find All Record</h3>
        <s:form action="/billing/pdf" method="get">
            <s:textfield name="name" label="Name"/>
            <%--    <s:textfield name="lastName" label="LastName" required="true" />--%>
            <s:submit value="Generate Report" />
        </s:form>
    </div>

<%--
  <div id="report">
      <h3>Download all information as a PDF</h3>
          <s:form action="pdf" method="post">
            <s:hidden name="timeZone" value="%{timeZone}" />
            <s:hidden name="time" value="%{time}" />
            <s:hidden name="clientIp" value="%{clientIp}" />
            <s:hidden name="country" value="%{country}" />
            <s:hidden name="regionName" value="%{regionName}" />
            <s:hidden name="city" value="%{city}" />
            <s:hidden name="isp" value="%{isp}" />
            <s:hidden name="as" value="%{as}" />
            <s:hidden name="browser" value="%{browser}" />
            <s:hidden name="bgpData" value="%{bgpData}" />
            <s:submit value="Download" />
          </s:form>
  </div>
    <div id="map">
          <div id="tooltip"></div>
          <svg width="960" height="600" id="statesvg"></svg>
          <script>

          	function tooltipHtml(n, d){	/* function to create html content string in tooltip div. */
          		return "<h4>"+n+"</h4><table>"+
          			"<tr><td>Low</td><td>"+(d.low)+"</td></tr>"+
          			"<tr><td>Average</td><td>"+(d.avg)+"</td></tr>"+
          			"<tr><td>High</td><td>"+(d.high)+"</td></tr>"+
          			"</table>";
          	}

          	var sampleData ={};	/* Sample random data. */
          	["HI", "AK", "FL", "SC", "GA", "AL", "NC", "TN", "RI", "CT", "MA",
          	"ME", "NH", "VT", "NY", "NJ", "PA", "DE", "MD", "WV", "KY", "OH",
          	"MI", "WY", "MT", "ID", "WA", "DC", "TX", "CA", "AZ", "NV", "UT",
          	"CO", "NM", "OR", "ND", "SD", "NE", "IA", "MS", "IN", "IL", "MN",
          	"WI", "MO", "AR", "OK", "KS", "LS", "VA"]
          		.forEach(function(d){
          			var low=Math.round(100*Math.random()),
          				mid=Math.round(100*Math.random()),
          				high=Math.round(100*Math.random());
          			sampleData[d]={low:d3.min([low,mid,high]), high:d3.max([low,mid,high]),
          					avg:Math.round((low+mid+high)/3), color:d3.interpolate("#ffffcc", "#800026")(low/100)};
          		});

          	/* draw states on id #statesvg */
          	uStates.draw("#statesvg", sampleData, tooltipHtml);

          	d3.select(self.frameElement).style("height", "600px");
          </script>
    </div>--%>
</sj:tabbedpanel>
</body>
</html>