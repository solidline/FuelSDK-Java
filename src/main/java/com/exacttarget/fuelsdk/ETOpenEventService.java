//
// ETOpenEventService.java -
//
//      x
//
// Copyright (C) 2013 ExactTarget
//
// @COPYRIGHT@
//

package com.exacttarget.fuelsdk;

import com.exacttarget.fuelsdk.filter.ETFilter;
import com.exacttarget.fuelsdk.model.ETOpenEvent;

public interface ETOpenEventService extends ETGetService {

	public ETResponse<ETOpenEvent> get(ETClient client)
	        throws ETSdkException;

	public ETResponse<ETOpenEvent> get(ETClient client, ETFilter filter)
	        throws ETSdkException;
}
