### show all buckets
```text
aws --endpoint-url=http://localhost:4566 s3 ls
```

### create bucket
```text
aws --endpoint-url=http://localhost:4566 s3 mb s3://BUCKET_NAME
```

### get all files from bucket
```text
aws --endpoint-url=http://localhost:4566 s3 ls s3://BUCKET_NAME
```

### delete bucket
```text
aws --endpoint-url=http://localhost:4566 s3 rb s3://BUCKET_NAME --force
```