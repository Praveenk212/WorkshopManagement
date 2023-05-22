DO '
BEGIN

	IF NOT EXISTS (
		SELECT
		FROM pg_catalog.pg_roles
		WHERE rolname = ''workshop'') THEN
		CREATE USER workshop nologin;
	END IF;
	IF NOT EXISTS (
		SELECT
		FROM pg_catalog.pg_roles
		WHERE rolname = ''workshop_admin'') THEN
		CREATE ROLE workshop_admin;
	END IF;
	IF NOT EXISTS (
		SELECT
		FROM pg_catalog.pg_roles
		WHERE rolname = ''workshop_write'') THEN
		CREATE ROLE workshop_write;
	END IF;
	IF NOT EXISTS (
		SELECT
		FROM pg_catalog.pg_roles
		WHERE rolname = ''workshop_read'') THEN
		CREATE ROLE workshop_read;
	END IF;

	CREATE SCHEMA IF NOT EXISTS workshop AUTHORIZATION workshop;
	GRANT USAGE ON SCHEMA workshop TO workshop_read;
	GRANT USAGE ON SCHEMA workshop TO workshop_write;
	GRANT USAGE ON SCHEMA workshop TO workshop_admin;
	GRANT workshop TO workshop_admin;

END;
' LANGUAGE plpgsql;