CREATE FUNCTION update_at_column() RETURNS trigger AS '
BEGIN
  NEW.updated_at = now();
  RETURN NEW;
END;
' language plpgsql;

CREATE TRIGGER update_customer_updated_at_column
    BEFORE UPDATE
    ON customer
    FOR EACH ROW
    EXECUTE PROCEDURE update_at_column();

CREATE TRIGGER update_freight_updated_at_column
    BEFORE UPDATE
    ON freight
    FOR EACH ROW
    EXECUTE PROCEDURE update_at_column();

CREATE TRIGGER update_customer_freight_updated_at_column
    BEFORE UPDATE
    ON customer_freight
    FOR EACH ROW
    EXECUTE PROCEDURE update_at_column();