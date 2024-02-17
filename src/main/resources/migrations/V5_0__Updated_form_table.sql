DO $$
    BEGIN
        IF NOT EXISTS (SELECT 1 FROM information_schema.columns WHERE table_name = 'form' AND column_name = 'closed_at' AND data_type = 'timestamp without time zone') THEN
            ALTER TABLE "form"
                ALTER COLUMN closed_at TYPE timestamp without time zone;
        END IF;
    END $$;

DO $$
    BEGIN
        IF NOT EXISTS (SELECT 1 FROM information_schema.columns WHERE table_name = 'form' AND column_name = 'opened_at' AND data_type = 'timestamp without time zone') THEN
            ALTER TABLE "form"
                ALTER COLUMN opened_at TYPE timestamp without time zone;
        END IF;
    END $$;

DO $$
    BEGIN
        IF NOT EXISTS (SELECT 1 FROM information_schema.columns WHERE table_name = 'form' AND column_name = 'created_at' AND data_type = 'timestamp without time zone') THEN
            ALTER TABLE "form"
                ALTER COLUMN created_at TYPE timestamp without time zone;
        END IF;
    END $$;

DO $$
    BEGIN
        IF NOT EXISTS (SELECT 1 FROM information_schema.columns WHERE table_name = 'form' AND column_name = 'updated_at' AND data_type = 'timestamp without time zone') THEN
            ALTER TABLE "form"
                ALTER COLUMN updated_at TYPE timestamp without time zone;
        END IF;
    END $$;
