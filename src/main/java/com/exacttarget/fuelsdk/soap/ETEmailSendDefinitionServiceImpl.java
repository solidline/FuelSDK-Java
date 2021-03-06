//
// ETEmailSendDefinitionServiceImpl.java -
//
//      x
//
// Copyright (C) 2013 ExactTarget
//
// @COPYRIGHT@
//

package com.exacttarget.fuelsdk.soap;

import java.util.List;

import com.exacttarget.fuelsdk.ETClient;
import com.exacttarget.fuelsdk.ETEmailSendDefinitionService;
import com.exacttarget.fuelsdk.ETSdkException;
import com.exacttarget.fuelsdk.ETResponse;
import com.exacttarget.fuelsdk.filter.ETFilter;
import com.exacttarget.fuelsdk.internal.EmailSendDefinition;
import com.exacttarget.fuelsdk.internal.InteractionBaseObject;
import com.exacttarget.fuelsdk.internal.PerformRequestMsg;
import com.exacttarget.fuelsdk.internal.PerformRequestMsg.Definitions;
import com.exacttarget.fuelsdk.internal.PerformResponseMsg;
import com.exacttarget.fuelsdk.internal.Soap;
import com.exacttarget.fuelsdk.model.ETEmailSendDefinition;
import com.exacttarget.fuelsdk.model.converter.ObjectConverter;

public class ETEmailSendDefinitionServiceImpl extends ETCrudServiceImpl<ETEmailSendDefinition>
		implements ETEmailSendDefinitionService {

	public ETResponse<ETEmailSendDefinition> get(ETClient client)
			throws ETSdkException {
		
		return super.get(client, ETEmailSendDefinition.class);
	}

	public ETResponse<ETEmailSendDefinition> get(ETClient client,
			ETFilter filter) throws ETSdkException {
		
		return super.get(client, ETEmailSendDefinition.class, filter);
	}

	public ETResponse<ETEmailSendDefinition> post(ETClient client,
			ETEmailSendDefinition emailSendDefinition) throws ETSdkException {
		
		return super.post(client, emailSendDefinition);
	}

	public ETResponse<ETEmailSendDefinition> patch(ETClient client,
			ETEmailSendDefinition emailSendDefinition) throws ETSdkException {
		
		return super.patch(client, emailSendDefinition);
	}

	public ETResponse<ETEmailSendDefinition> delete(ETClient client,
			ETEmailSendDefinition emailSendDefinition) throws ETSdkException {
		
		return super.delete(client, emailSendDefinition);
	}
	
	public ETResponse<ETEmailSendDefinition> post(ETClient client,
			List<ETEmailSendDefinition> emailSendDefinitions) throws ETSdkException {
		
		return super.post(client, emailSendDefinitions);
	}

	public ETResponse<ETEmailSendDefinition> patch(ETClient client,
			List<ETEmailSendDefinition> emailSendDefinitions) throws ETSdkException {
		
		return super.patch(client, emailSendDefinitions);
	}

	public ETResponse<ETEmailSendDefinition> delete(ETClient client,
			List<ETEmailSendDefinition> emailSendDefinitions) throws ETSdkException {
		
		return super.delete(client, emailSendDefinitions);
	}

	public ETResponse<ETEmailSendDefinition> send(ETClient client,
			ETEmailSendDefinition emailSendDefinition) throws ETSdkException {
		
		Soap soap = client.getSOAPConnection().getSoap();
		
		InteractionBaseObject apiObject;
		try {
            apiObject = ObjectConverter.convertFromEtObject(emailSendDefinition, EmailSendDefinition.class, false);
		}
        catch(Exception e) {
            throw new ETSdkException("Error instantiating object", e);
        }
		
		Definitions definitions = new Definitions();
		definitions.getDefinition().add(apiObject);
		
		PerformRequestMsg performRequestMsg = new PerformRequestMsg();
		performRequestMsg.setAction("start");
		performRequestMsg.setDefinitions(definitions);

		PerformResponseMsg performResponseMsg = soap.perform(performRequestMsg);

        ETResponse<ETEmailSendDefinition> response = new ETServiceResponseImpl<ETEmailSendDefinition>();
        response.setRequestId(performResponseMsg.getRequestID());

        return response;
	}

}
