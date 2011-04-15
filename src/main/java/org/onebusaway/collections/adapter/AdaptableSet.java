/**
 * Copyright (C) 2011 bdferris <bdferris@onebusaway.org>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.onebusaway.collections.adapter;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;

class AdaptableSet<FROM, TO> extends AbstractSet<TO> {

  private final Set<FROM> _source;

  private final IAdapter<FROM, TO> _adapter;

  public AdaptableSet(Set<FROM> source, IAdapter<FROM, TO> adapter) {
    _source = source;
    _adapter = adapter;
  }

  @Override
  public Iterator<TO> iterator() {
    return AdapterLibrary.adaptIterator(_source.iterator(), _adapter);
  }

  @Override
  public int size() {
    return _source.size();
  }

}
