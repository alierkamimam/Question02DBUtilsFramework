@db
Feature:

  Scenario Outline: Verify the homework first questions's answer with DB
    Given "<month_name>" "<full_name>" "<total_amount>" should match with the result
    Examples:
      | month_name | full_name    | total_amount |
      | February   | Mike Hillyer | 4160.84      |
      | February   | Jon Stephens | 4191.00      |
      | March      | Mike Hillyer | 11776.83     |
      | March      | Jon Stephens | 12109.73     |
      | April      | Mike Hillyer | 14080.36     |
      | April      | Jon Stephens | 14479.10     |
      | May        | Mike Hillyer | 234.09       |
      | May        | Jon Stephens | 280.09       |