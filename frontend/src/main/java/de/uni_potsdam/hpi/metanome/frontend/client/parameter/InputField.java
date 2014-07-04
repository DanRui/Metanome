/*
 * Copyright 2014 by the Metanome project
 *
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

package de.uni_potsdam.hpi.metanome.frontend.client.parameter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;

public abstract class InputField extends HorizontalPanel {

  protected Button removeButton;
  protected boolean isOptional;

  public InputField(boolean optional) {
    super();
    this.isOptional = optional;

    if (this.isOptional) {
      createRemoveButton();
    }
  }

  /**
   * Creates the remove button.
   */
  protected void createRemoveButton() {
    this.removeButton = new Button("Remove");
    this.removeButton.addClickHandler(new ClickHandler() {

      @Override
      public void onClick(ClickEvent event) {
        removeSelf();
      }
    });
    this.add(this.removeButton);
  }

  public void removeSelf() {
    ((InputParameterWidget) this.getParent()).removeField(this);
  }

}