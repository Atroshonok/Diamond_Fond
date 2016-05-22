<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	
	<xsl:output method="html" encoding="Windows-1251"/>

	<xsl:template match="/">
		<html>
			<head>
				<title>Diamond Fond</title>
				<style type="text/css">
				tr:first-child {background-color: #0FF;}
				td {background-color: rgba(255,255,0,.5);}
				
				</style>
			</head>
			<body>
				<table align="center" border="1" cellspacing="0" cellpadding="5">
					<caption>Параметры драгоценных камней</caption>
					<tr>
						<th>Gem id</th>
						<th>Name</th>
						<th>Preciousness</th>
						<th>Origin</th>
						<th>Value, ct.</th>
						<th>Color</th>
						<th>Transparency, %</th>
						<th>Number of faces</th>
					</tr>
						<xsl:apply-templates/>
				</table>
			</body>
		</html>
	</xsl:template>
	
	<xsl:template match="gem">
		<tr>
			<td align="center">
				<xsl:value-of select="@id"/>
			</td>
			<td>
				<xsl:value-of select="name"/>
			</td>
			<td>
				<xsl:value-of select="preciousness"/>
			</td>
			<td>
				<xsl:value-of select="origin"/>
			</td>
			<td align="center">
				<xsl:value-of select="value"/>
			</td>
			<td align="center">
				<xsl:value-of select="visual-parameters-list/color"/>
			</td>
			<td align="center">
				<xsl:value-of select="visual-parameters-list/transparency"/>
			</td>
			<td align="center">
				<xsl:value-of select="visual-parameters-list/facescount"/>
			</td>
		</tr>
	</xsl:template>
	
</xsl:stylesheet>



