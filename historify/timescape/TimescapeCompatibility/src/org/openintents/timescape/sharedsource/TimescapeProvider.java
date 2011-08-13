/* 
 * Copyright (C) 2011 OpenIntents.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openintents.timescape.sharedsource;

import org.openintents.historify.data.providers.Events;
import org.openintents.historify.data.providers.EventsProvider;

import android.database.Cursor;
import android.database.MatrixCursor;

public class TimescapeProvider extends EventsProvider{

	@Override
	protected String getAuthority() {
		return SourceConstants.AUTHORITY;
	}

	@Override
	protected Cursor queryEvent(long eventKey) {
		return null;
	}

	@Override
	protected Cursor queryEvents() {
		return null;
	}

	@Override
	protected Cursor queryEventsByKey(String eventKey) {
		return null;
	}

	@Override
	protected Cursor queryEventsForContact(String lookupKey) {

		MatrixCursor mc = new MatrixCursor(new String[] {
				Events._ID,
				Events.CONTACT_KEY,
				Events.EVENT_KEY,
				Events.MESSAGE,
				Events.ORIGINATOR,
				Events.PUBLISHED_TIME
				
		});
		
		mc.addRow(new Object[] {
					1l, 
					lookupKey, 
					null,
					"Hello, Timescape!",
					Events.Originator.contact,
					System.currentTimeMillis()
			});	

		return mc;
	}

}