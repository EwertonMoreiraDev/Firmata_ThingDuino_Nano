package com.helloinc.things.goodbye;

import org.slf4j.Logger;

import com.thingworx.logging.LogUtilities;
import com.thingworx.metadata.annotations.ThingworxConfigurationTableDefinition;
import com.thingworx.metadata.annotations.ThingworxConfigurationTableDefinitions;
import com.thingworx.metadata.annotations.ThingworxDataShapeDefinition;
import com.thingworx.metadata.annotations.ThingworxFieldDefinition;
import com.thingworx.metadata.annotations.ThingworxServiceDefinition;
import com.thingworx.metadata.annotations.ThingworxServiceParameter;
import com.thingworx.metadata.annotations.ThingworxServiceResult;
import com.thingworx.resources.entities.EntityServices;
import com.thingworx.system.managers.ResourceManager;
import com.thingworx.system.managers.ThingManager;
import com.thingworx.things.Thing;
import com.thingworx.types.ConfigurationTable;
import com.thingworx.types.InfoTable;
import com.thingworx.types.collections.ValueCollection;
import com.thingworx.types.primitives.NumberPrimitive;

@ThingworxConfigurationTableDefinitions(tables = {
		  @ThingworxConfigurationTableDefinition(name = "Digital Inputs", description = "", ordinal = 0, dataShape =            
		     @ThingworxDataShapeDefinition(fields = {
		            @ThingworxFieldDefinition(name = "Port 0", description = "Configure to Input, Output or PWM. Port 0 can also be used for serial communication", baseType = "STRING", ordinal = 0, aspects = {
				               "defaultValue:I",
				               "selectOptions:I:INPUT|O:OUTPUT|P:PWM",
				               "friendlyName:PORT 0" }),
		            @ThingworxFieldDefinition(name = "Port 1", baseType = "STRING", ordinal = 1, aspects = {
				               "defaultValue:I",
				               "selectOptions:I:INPUT|O:OUTPUT|P:PWM",
				               "friendlyName:PORT 1" }),
		            @ThingworxFieldDefinition(name = "Port 2", baseType = "STRING", ordinal = 2, aspects = {
				               "defaultValue:I",
				               "selectOptions:I:INPUT|O:OUTPUT|P:PWM",
				               "friendlyName:PORT 2" }),
		            @ThingworxFieldDefinition(name = "Port 3", baseType = "STRING", ordinal = 3, aspects = {
				               "defaultValue:I",
				               "selectOptions:I:INPUT|O:OUTPUT|P:PWM",
				               "friendlyName:PORT 3" }),
		            @ThingworxFieldDefinition(name = "Port 4", baseType = "STRING", ordinal = 4, aspects = {
				               "defaultValue:I",
				               "selectOptions:I:INPUT|O:OUTPUT|P:PWM",
				               "friendlyName:PORT 4" }),
		            @ThingworxFieldDefinition(name = "Port 5", baseType = "STRING", ordinal = 5, aspects = {
				               "defaultValue:I",
				               "selectOptions:I:INPUT|O:OUTPUT|P:PWM",
				               "friendlyName:PORT 5" }),
		            @ThingworxFieldDefinition(name = "Port 6", baseType = "STRING", ordinal = 6, aspects = {
				               "defaultValue:I",
				               "selectOptions:I:INPUT|O:OUTPUT|P:PWM",
				               "friendlyName:PORT 6" }),
		            @ThingworxFieldDefinition(name = "Port 7", baseType = "STRING", ordinal = 7, aspects = {
				               "defaultValue:I",
				               "selectOptions:I:INPUT|O:OUTPUT|P:PWM",
				               "friendlyName:PORT 7" }),
		            @ThingworxFieldDefinition(name = "Port 8", baseType = "STRING", ordinal = 8, aspects = {
				               "defaultValue:I",
				               "selectOptions:I:INPUT|O:OUTPUT|P:PWM",
				               "friendlyName:PORT 8" }),
		            @ThingworxFieldDefinition(name = "Port 9", baseType = "STRING", ordinal = 9, aspects = {
				               "defaultValue:I",
				               "selectOptions:I:INPUT|O:OUTPUT|P:PWM",
				               "friendlyName:PORT 9" }),
		            @ThingworxFieldDefinition(name = "Port 10", baseType = "STRING", ordinal = 10, aspects = {
				               "defaultValue:I",
				               "selectOptions:I:INPUT|O:OUTPUT|P:PWM",
				               "friendlyName:PORT 10" }),
		            @ThingworxFieldDefinition(name = "Port 11", baseType = "STRING", ordinal = 11, aspects = {
				               "defaultValue:I",
				               "selectOptions:I:INPUT|O:OUTPUT|P:PWM",
				               "friendlyName:PORT 11" }),
		            @ThingworxFieldDefinition(name = "Port 12", baseType = "STRING", ordinal = 12, aspects = {
				               "defaultValue:I",
				               "selectOptions:I:INPUT|O:OUTPUT|P:PWM",
				               "friendlyName:PORT 12" }),
		            @ThingworxFieldDefinition(name = "Port 13", baseType = "STRING", ordinal = 13, aspects = {
				               "defaultValue:I",
				               "selectOptions:I:INPUT|O:OUTPUT|P:PWM",
				               "friendlyName:PORT 13" }),
		            @ThingworxFieldDefinition(name = "Port 14", baseType = "STRING", ordinal = 14, aspects = {
				               "defaultValue:I",
				               "selectOptions:I:INPUT|O:OUTPUT|P:PWM",
				               "friendlyName:PORT 14" })
		    }))
		})

public class GoodByeThing extends Thing {
	
	protected static Logger _logger = LogUtilities.getInstance().getApplicationLogger(GoodByeThing.class);
	
	@Override
	public void initializeThing() throws Exception {
		super.initializeThing();
		
		_logger.warn("****** Initializing GoodByeThingInstance " + getName());
		
		// Examples of getting the configuration table values
		String field1Value = (String)getConfigurationData().getValue("ConfigTableExample1", "field1");
		Double field2Value = (Double)getConfigurationData().getValue("ConfigTableExample1", "field2");
		Boolean field3Value = (Boolean)getConfigurationData().getValue("ConfigTableExample1", "field3");
		String field4Value = (String)getConfigurationData().getValue("ConfigTableExample1", "field4");
		
		// Example of setting a configuration table value
		setNumberConfigurationSetting("ConfigTableExample1", "field2", (field2Value + 2.1));
		SaveConfigurationTables();
		// Another example
		setConfigurationSetting("ConfigTableExample1", "field2", ((Double)getConfigurationData().getValue("ConfigTableExample1", "field2") + 5.5));
		SaveConfigurationTables();
		
		// Example of getting multi-row configuration table data
		ConfigurationTable tableTwo = getConfigurationData().getConfigurationTable("ConfigTableExample2");
		
		_logger.warn("****** Iterating " + tableTwo.getName() + " of goodbye thing instance  " + getName());
		_logger.warn("****** " + tableTwo.getName() + " has " + tableTwo.getRowCount() + " rows");
		
		int counter = 0;
		for(ValueCollection row : tableTwo.getRows()) {
			
			String columnA = row.getStringValue("columnA");
			Double columnB = (Double)row.getValue("columnB");
			Boolean columnC = (Boolean)row.getValue("columnC");
			String columnD = row.getStringValue("columnD");

			_logger.warn("columnA row " + counter++ + " value is " + columnA);
			_logger.warn("columnB row " + counter++ + " value is " + columnB);
			_logger.warn("columnC row " + counter++ + " value is " + columnC);
			_logger.warn("columnD row " + counter++ + " value is " + columnD);
		}
	}
	
	// Property set of another Thing
	@ThingworxServiceDefinition( name="SetHelloWorldProperty", description="Set a property on Hello world" )
	public void SetHelloWorldProperty(
			@ThingworxServiceParameter( name="thingToSet", description="The thing you're setting", baseType="THINGNAME", aspects={"thingTemplate:HelloWorld"} ) String thingToSet,
			@ThingworxServiceParameter( name="numberPropertyToSet", description="The property name you're setting", baseType="STRING" ) String numberPropertyToSet,
			@ThingworxServiceParameter( name="numberValueToSet", description="The propert value you're setting", baseType="NUMBER") Double numberValueToSet) throws Exception {

		Thing helloThing = ThingManager.getInstance().getEntity(thingToSet);
		helloThing.setPropertyValue(numberPropertyToSet, new NumberPrimitive(numberValueToSet));
	}
	
	// Access a Resource
	@ThingworxServiceDefinition( name="AccessAResource", description="Execute a service of a resource" )
	@ThingworxServiceResult( name="result", description="Matching entries", baseType="INFOTABLE", aspects={"dataShape:RootEntityList"} )
	public InfoTable AccessAResource() throws Exception {

		// Easiest way to do this as well as access any service of a Thing is simply to call what you see in Composer.
		EntityServices entityService = (EntityServices)ResourceManager.getInstance().getEntity("EntityServices");
		
		return entityService.GetEntityList("Thing", "", null, null);
	}

}
