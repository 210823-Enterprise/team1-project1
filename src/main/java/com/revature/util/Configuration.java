package com.revature.util;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.revature.objectMapper.Query;

public class Configuration {
	

	private List<MetaModel<Class<?>>> metaModelList;
	
	// this essentially does what the Hibernate.cfg.xml mapping property does!
	public Configuration addAnnotatedClass(Class annotatedClass) {
		
		if (metaModelList == null) {
			
			metaModelList = new LinkedList<>();
			
		}
		
		metaModelList.add(MetaModel.of(annotatedClass)); // we will amke this of() method
		
		// Create the of() method inside MetaModel to trasform a class
		// into an appropraite data model to be transposed into a relational db object.
		
		return this;
	}
	
	public void addTable(MetaModel<?> metamodel) {
		Query q = new Query();
		q.createTable(metamodel);
		
		// loop through tables and add call the Query.creatTable(class) ????
//		for (MetaModel<Class<?>> clazz : metaModelList) {
//			
//		}
	}
	
	public List<MetaModel<Class<?>>> getMetaModels() {
		
		return (metaModelList == null) ? Collections.emptyList() : metaModelList;
		
	}
	
	

}




