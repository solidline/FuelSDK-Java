//
// ETSentEventService.java -
//
//      x
//
// Copyright (C) 2013 ExactTarget
//
// @COPYRIGHT@
//

package com.exacttarget.fuelsdk;

import com.exacttarget.fuelsdk.filter.ETFilter;
import com.exacttarget.fuelsdk.model.ETSentEvent;

public interface ETSentEventService extends ETGetService {

	public ETResponse<ETSentEvent> get(ETClient client)
	        throws ETSdkException;

	public ETResponse<ETSentEvent> get(ETClient client, ETFilter filter)
	        throws ETSdkException;
}
