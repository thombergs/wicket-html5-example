package org.wickedsource;

import java.util.Date;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.EmailTextField;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.NumberTextField;
import org.apache.wicket.markup.html.form.RangeTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);
		add(new Html5Form("html5Form"));
	}

	private class Html5Form extends Form {

		private Integer number;

		private Integer numberInRange;

		private String email;

		private Date dateRange;

		public Html5Form(String wicketId) {
			super(wicketId);
			add(new NumberTextField<Integer>("numberField",
					new PropertyModel<Integer>(this, "number")));

			RangeTextField<Integer> rangeField = new RangeTextField<Integer>(
					"rangeField", new PropertyModel<Integer>(this,
							"numberInRange"));
			rangeField.setMinimum(5);
			rangeField.setMaximum(10);
			add(rangeField);

			add(new EmailTextField("emailField", new PropertyModel<String>(
					this, "email")));

			DateRangeField dateRangeField = new DateRangeField(
					"dateRangeField",
					new PropertyModel<Date>(this, "dateRange"), "2011-01-10",
					"2011-01-20");
			add(dateRangeField);

		}

		private class DateRangeField extends TextField<Date> {

			public DateRangeField(String id, IModel<Date> model,
					String minDate, String maxDate) {
				super(id, model);
				add(new AttributeAppender("min", minDate));
				add(new AttributeAppender("max", maxDate));
				add(new AttributeAppender("value", minDate));
			}

			@Override
			protected String getInputType() {
				return "date";
			}

		}

	}

}
