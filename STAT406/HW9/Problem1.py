import pandas as pd
import statsmodels.api as sm
from statsmodels.formula.api import mixedlm

# Load the dataset
data = pd.read_excel('STAT406\HW9\Corrosion.xlsx')

# Fit a mixed-effects model
# Temperature as the whole plot factor with random intercept
# Coating as a fixed effect, and Temperature*Coating interaction also as a fixed effect
model = mixedlm("resistance ~ C(Coating) * C(Temperature)", data,  groups=data["Whole Plots"])

result = model.fit(reml=True)
print(result.summary())

# Extract variance components
variance_components = result.random_effects
whole_plot_var = result.cov_re.iloc[0, 0]
residual_var = result.scale

# Calculate whole plot effect size ratio
ratio = whole_plot_var / residual_var

# Calculate proportion of variance
total_variance = whole_plot_var + residual_var
whole_plot_prop = (whole_plot_var / total_variance) * 100
residual_prop = (residual_var / total_variance) * 100

print(f"Whole plot variance: {whole_plot_var}")
print(f"Residual variance: {residual_var}")
print(f"Whole plot effect is {ratio:.2f} times greater than residual variance.")
print(f"{whole_plot_prop:.2f}% of total variance due to whole plot.")
print(f"{residual_prop:.2f}% of total variance due to residual.")

# Check for significant interaction effect
p_value_interaction = result.pvalues['C(Coating)[T.C2]:C(Temperature)[T.370]']
print(f"Interaction p-value: {p_value_interaction}")

# Determine the best coating and temperature
best_combination = data.groupby(["Coating", "Temperature"])["resistance"].mean().idxmax()
print(f"Best combination for resistance: Coating {best_combination[0]}, Temperature {best_combination[1]}")

# Confidence in decision making (95% vs 99%)
confident_decision = p_value_interaction < 0.01
print(f"At 99% confidence, is the interaction still significant? {'Yes' if confident_decision else 'No'}")
