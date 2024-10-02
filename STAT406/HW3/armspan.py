import pandas as pd
from scipy import stats

# Load the dataset
df = pd.read_excel("Stat406/armspan_alldatagendernames.xlsx")

# Filter data for males (gender = 0)
males_data = df[df['gender'] == 0]

# Paired t-test (Parametric Test)
t_stat, p_value = stats.ttest_rel(males_data['height'], males_data['armspan'])

# Wilcoxon Signed-Rank Test (Non-parametric Test)
w_stat, w_p_value = stats.wilcoxon(males_data['height'], males_data['armspan'])

# Interpretation
alpha = 0.10
parametric_result = "reject" if p_value < alpha else "fail to reject"
non_parametric_result = "reject" if w_p_value < alpha else "fail to reject"

{
    "t_stat": t_stat,
    "p_value_ttest": p_value,
    "w_stat": w_stat,
    "p_value_wilcoxon": w_p_value,
    "parametric_result": parametric_result,
    "non_parametric_result": non_parametric_result
}