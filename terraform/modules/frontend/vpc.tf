resource "aws_vpc" "default" {
  cidr_block = "${var.VPC_CIDR}"
  enable_dns_hostnames = true

  tags {
      Name = "${var.ENVIRONMENT}-my_Task1_VPC"
  }
}
