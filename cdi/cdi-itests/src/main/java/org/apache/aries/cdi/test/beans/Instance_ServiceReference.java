/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.aries.cdi.test.beans;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.apache.aries.cdi.test.interfaces.BeanService;
import org.apache.aries.cdi.test.interfaces.SingletonScoped;
import org.osgi.framework.ServiceReference;
import org.osgi.service.cdi.annotations.Reference;
import org.osgi.service.cdi.annotations.Service;
import org.osgi.service.cdi.annotations.SingleComponent;

@SingleComponent
@Service({BeanService.class, Instance_ServiceReference.class})
@SuppressWarnings("rawtypes")
public class Instance_ServiceReference implements BeanService<ServiceReference> {

	@Override
	public String doSomething() {
		return String.valueOf(_instance.size());
	}

	@Override
	public ServiceReference get() {
		Iterator<ServiceReference> iterator = _instance.iterator();
		if (iterator.hasNext())
			return iterator.next();
		return null;
	}

	@Inject
	@Reference(SingletonScoped.class)
	List<ServiceReference> _instance;

}
