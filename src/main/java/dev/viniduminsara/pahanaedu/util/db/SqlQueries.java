package dev.viniduminsara.pahanaedu.util.db;

public class SqlQueries {

    public static final class Customer {
        public static final String INSERT =
            "INSERT INTO customer (customer_id, name, address, mobile_number, units_consumed, registration_date, email) VALUES (?, ?, ?, ?, ?, ?, ?)";

        public static final String FIND_BY_ID =
            "SELECT * FROM customer WHERE customer_id = ?";

        public static final String FIND_ALL =
            "SELECT * FROM customer";

        public static final String UPDATE =
            "UPDATE customer SET name = ?, address = ?, mobile_number = ?, email = ? WHERE customer_id = ?";

        public static final String DELETE =
            "DELETE FROM customer WHERE customer_id = ?";

        public static final String COUNT =
            "SELECT COUNT(*) FROM customer";

        public static final String UPDATE_UNIT_CONSUMED =
            "UPDATE customer SET units_consumed = units_consumed + ? WHERE customer_id = ?";
    }

    public static final class Item {
        public static final String INSERT =
            "INSERT INTO item (item_code, item_name, description, category, unit_price, stock_quantity, publisher, author) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        public static final String FIND_BY_ID =
            "SELECT * FROM item WHERE item_code = ?";

        public static final String FIND_ALL =
            "SELECT * FROM item";

        public static final String UPDATE =
            "UPDATE item SET item_name = ?, description = ?, category = ?, unit_price = ?, stock_quantity = ?, publisher = ?, author = ? WHERE item_code = ?";

        public static final String DELETE =
            "DELETE FROM item WHERE item_code = ?";

        public static final String COUNT =
            "SELECT COUNT(*) FROM item";

        public static final String UPDATE_STOCK =
            "UPDATE item SET stock_quantity = stock_quantity - ? WHERE item_code = ?";
    }

    public static final class Bill {
        public static final String INSERT =
                "INSERT INTO bill (bill_id, bill_date, customer_id, total_amount) VALUES (?, ?, ?, ?)";

        public static final String COUNT =
            "SELECT COUNT(*) FROM bill";

        public static final String FIND_ALL =
            "SELECT * FROM bill";
    }

    public static final class BillItem {
        public static final String INSERT =
                "INSERT INTO bill_item (bill_id, item_code, quantity, unit_price) VALUES (?, ?, ?, ?)";
    }

    public static final class User {
        public static final String FIND_BY_USERNAME_AND_PASSWORD =
                "SELECT * FROM user WHERE username = ? AND password = ?";
    }

}
