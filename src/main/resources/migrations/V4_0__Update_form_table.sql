DO $$
    BEGIN
        IF NOT EXISTS (SELECT 1 FROM information_schema.columns WHERE table_name = 'form' AND column_name = 'updated_at') THEN
            ALTER TABLE "form" ADD COLUMN updated_at timestamptz DEFAULT current_timestamp;
        END IF;
    END $$;
