/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca
 * http://www.dynamicreports.org
 *
 * This file is part of DynamicReports.
 *
 * DynamicReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * DynamicReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.dynamicreports.examples.column;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;
import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JREmptyDataSource;

/**
 * <p>RowNumberColumnsReport class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class RowNumberColumnsReport {

	/**
	 * <p>Constructor for RowNumberColumnsReport.</p>
	 */
	public RowNumberColumnsReport() {
		build();
	}

	private void build() {
		try {
			report()
					.setTemplate(Templates.reportTemplate)
					.setPageColumnsPerPage(2)
					.setPageColumnSpace(10)
					.columns(
							col.reportRowNumberColumn("Report row"),
							col.pageRowNumberColumn("Page row"),
							col.columnRowNumberColumn("Page column row"))
					.title(Templates.createTitleComponent("RowNumberColumns"))
					.pageFooter(Templates.footerComponent)
					.setDataSource(new JREmptyDataSource(150))
					.show();
		} catch (DRException e) {
			e.printStackTrace();
		}
	}

	/**
	 * <p>main.</p>
	 *
	 * @param args an array of {@link java.lang.String} objects.
	 */
	public static void main(String[] args) {
		new RowNumberColumnsReport();
	}
}
