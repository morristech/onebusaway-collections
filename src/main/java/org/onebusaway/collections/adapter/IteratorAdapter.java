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

import java.util.Iterator;

class IteratorAdapter<FROM, TO> implements Iterator<TO> {

  private final Iterator<FROM> _it;

  private final IAdapter<FROM, TO> _adapter;

  public IteratorAdapter(Iterator<FROM> it, IAdapter<FROM, TO> adapter) {
    _it = it;
    _adapter = adapter;
  }

  public boolean hasNext() {
    return _it.hasNext();
  }

  public TO next() {
    return _adapter.adapt(_it.next());
  }

  public void remove() {
    _it.remove();
  }
}