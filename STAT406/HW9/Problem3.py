import pandas as pd
import statsmodels.api as sm
import statsmodels.formula.api as smf

# Load the dataset
data = pd.read_csv(r'c:\Users\ssjed\OneDrive\Documents\GitHub\Fall2024\STAT406\HW9\sscores.csv')

# Inspect the data to verify the structure
print(data.head())

# Fit a mixed-effects model: Score ~ Material + (1|Teacher)
# Teacher is treated as a random effect
model = smf.mixedlm("score ~ C(material)", data, groups=data["teacher"])
fit = model.fit(reml=True)  # REML for variance component estimation

# Print the summary of the mixed model
print(fit.summary())

# Extracting relevant p-values to answer questions
material_pvalues = fit.pvalues.filter(like="material")
print(f"Material P-values:\n{material_pvalues}")

# Report if Material is a significant factor at 95% confidence
if any(material_pvalues < 0.05):
    print("Yes, Material is a significant factor (95% confidence).")
else:
    print("No, Material is not a significant factor (95% confidence).")

# Extract variance components for the teacher random effect
variance_components = fit.cov_re
print(f"Variance Components (Teacher):\n{variance_components}")

print(f"Residual Variance Confidence Interval: {residual_variance_ci}")
# Report residual variance and confidence interval
residual_variance = fit.scale
print(f"Residual Variance: {residual_variance}")