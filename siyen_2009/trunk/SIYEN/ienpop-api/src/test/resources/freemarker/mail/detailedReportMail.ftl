<#setting locale="en_US">
<#setting date_format="MM/dd">
<html>
<head>
<style type="text/css">
a:link{

}
a {
	font-family:"Trebuchet MS";
	font-size:11px;
	color:#FF3300;
	vertical-align: middle;
	font-weight:bolder;
	text-decoration: none;
}
a:hover {
	font-family:"Trebuchet MS";
	font-size:11px;
	color:#3366FF;
	vertical-align: middle;
	font-weight:bolder;
	text-decoration: none;
}
a:active {
	
}

a:visited {

}
.tableHeader{
	font-family:"Trebuchet MS";
	font-size:12px;
	color:#135A80;
	font-weight:bold;
	text-align: center;
	vertical-align: middle;
}
.tableHeaderBlue{
	font-family:"Trebuchet MS";
	font-size:12px;
	color:#003366;
	background-color:#B0D8FF;
	font-weight:bold;
	text-align: center;
	vertical-align: middle;
}
.titleHeader{
	font-family:"Trebuchet MS";
	font-size:13px;
	color:#FFFFFF;
	font-weight:bold;
	text-align: center;
	vertical-align: middle;
}
.titleHeaderBlue{
	font-family:"Trebuchet MS";
	font-size:13px;
	color:#FFFFFF;
	background-color:#336699;
	font-weight:bold;
	text-align: center;
	vertical-align: middle;
}
.titleHeaderRed{
	font-family:"Trebuchet MS";
	font-size:13px;
	color:#FFFFFF;
	background-color:#CC3300;
	font-weight:bold;
	text-align: center;
	vertical-align: middle;
}
.tableContentFill{
	font-family:"Trebuchet MS";
	font-size:11px;
	color:#000000;
	background-color:#EAEAEA;
	text-align: center;
	vertical-align: middle;
}
.tableContentNoFill{
	font-family:"Trebuchet MS";
	font-size:11px;
	color:#333333;
	text-align: center;
	vertical-align: middle;
}
</style>
</head>
<body>
	<table border="0" cellspacing="0" cellpadding="0" width="100%">
	<td>
		<tr>
	<table border="0" cellspacing="0" cellpadding="0" width="100%">
		<tr>
			<td class="titleHeaderBlue">
				&nbsp;
				&nbsp;
			</td>
			<td align="center" class="titleHeaderBlue">${account.ownersName?default('')} - From ${since.time?date} until ${until.time?date} </td>
			<td class="titleHeaderBlue">
				&nbsp;
				&nbsp;
			</td>
		</tr>
	</table>
		</tr>
	</td>
	<tr>
		<td>
	<table border="0" width="100%">
		<tr class="titleHeaderRed">
			<td class="titleHeaderRed">Subscriber/Date</td>
			<#list dateInterval as currentDate>
				<td class="titleHeaderRed">${currentDate?date}</td>
			</#list>
			<td class="titleHeaderRed">Total</td>
		</tr>
		<#list replenishRecords as record>
		<tr class="<#if (record_index%2)=0>tableContentNoFill<#else>tableContentFill</#if>">
			<#list record as r>
				<#if r_index = 0>
					<td>
						<a href="reportSubscriber.va?subscriberNumber=${r?default('')}">${r?default('')}</a>
					</td>
				<#else>
					<td>
						<#if r?has_content>
							${r?default('')}
						<#else>
							&nbsp;
						</#if>
					</td>
				</#if>
			</#list>
		</tr>
		</#list>
		<tr class="tableHeader">
			<td class="tableHeaderBlue">Total</img></td>
			<#list dailyAmounts as dailyAmount>
				<td class="tableHeaderBlue">${dailyAmount?string("$,##0.00")}</td>
			</#list>
			<td class="tableHeaderBlue">${total?string("$,##0.00")}</td>
		</tr>
	</table>
	<br>
	<table border="0" width="250">
		<tr>
			<td class="titleHeaderRed">Activated Subscribers</td>
			<td class="tableHeaderBlue">${activatedSubscribers?default('')}</td>
		</tr>
		<tr>
			<td class="titleHeaderRed">Subscribers With Replenish</td>
			<td class="tableHeaderBlue">${subscribersWithReplenishCount?default('')}</td>
		</tr>
		<tr>
			<td class="titleHeaderRed">Replenish Records Count</td>
			<td class="tableHeaderBlue">${replenishRecordsCount?default('')}</td>
		</tr>
		<tr>
			<td class="titleHeaderRed">Total Replenishment</td>
			<td class="tableHeaderBlue">${total?string("$,##0.00")}</td>
		</tr>
	</table>
		</td>
	</td>
	</table>
</body>
</html>