package com.nt.test;

import java.util.List;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.controller.MainController;
import com.nt.dto.StateDTO;

public class NestedBeanFactoryTestUsingDLBF {

	public static void main(String[] args) {
		
		DefaultListableBeanFactory pFactory=null,cFactory=null;
		XmlBeanDefinitionReader pReader=null,cReader=null;
		MainController controller=null;
		List<StateDTO> listDTO=null;
		//create ParentContainer
		pFactory=new DefaultListableBeanFactory();
		pReader=new XmlBeanDefinitionReader(pFactory);
		pReader.loadBeanDefinitions("com/nt/cfgs/business-beans.xml");
		//create child container
		cFactory=new DefaultListableBeanFactory(pFactory);
		cReader=new XmlBeanDefinitionReader(cFactory);
		cReader.loadBeanDefinitions("com/nt/cfgs/presentation-beans.xml");
		//get Controller class object
		controller=cFactory.getBean("controller",MainController.class);
		
		try {
			//invoke method
			listDTO = controller.fetchStateInfoByName(new String[] {"New Delhi","Hyderabad"});
			listDTO.forEach(dto->{
				System.out.println(dto);
			});
		}
		catch(Exception e) {
			System.out.println("Internal Problem");
		}
	}
}