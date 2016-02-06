package by.ittc.horsebetting.dao.impl.jdbc;

import javax.sql.DataSource;

public abstract class AbstractDAO {
	protected DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	protected void close(AutoCloseable... closeables) {

		for (AutoCloseable closeable : closeables) {
			try {
				if (closeable != null) {
					try {
						closeable.close();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
